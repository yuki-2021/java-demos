import Vuex from 'vuex'
import mtypes  from './mutations-type.js';


const moduleA = {
	state: {
		msgA: 'a'
	},
	mutations: {
		changeMsgA(state) {
			state.msgA = 'changed !!!'
		}
	}
}

const defaultModule = {
	state: {
		count: 1,
		peopleList: [
			{ name: 'kobe', age: 21 },
			{ name: 'lilei', age: 13 },
			{ name: 'hanmeimei', age: 14 }
		],
		numList: [1, 2],
		info: {
			name: 'yuki',
			age: 12
		}
	},
	getters: {
		stuList(state) {
			return state.peopleList.filter((item) => item.age <= 18);
		},
		stuCount(state, getters) {
			return getters.stuList.length;
		},
		ageCount(state) {
			return (minAge) => state.peopleList.filter((item) => item.age >= minAge);
		}
	},
	mutations: {
		[mtypes.ADD_ONE](state) {
			state.count ++;
		},
		addNum(state, num) {
			state.count += num;
		},
		addPlus(state,payload) {
			state.count += (payload.num1 * payload.num2);
		},
		// --------- 修改 numList和info
		addToNumList(state, payload) {
			console.log(payload);
			state.numList[2] = payload;
		},
		addInfo(state) {
			console.log(state.info);
			delete state.info.name;
			console.log(state.info);
		}
	},
	actions: {
		addOne(context) {
			console.log(context);
			setTimeout(() => {context.commit('addOne')}, 1000)
		},
		addNum(context, payload) {
			console.log(context);
			console.log(payload);
			setTimeout(() => {context.commit('addNum',payload)}, 1000)
		},
		addPlus(context,payload) {
			console.log(context);
			console.log(payload);
			setTimeout(() => {context.commit('addPlus',payload)}, 1000)
		},
		addOneAndLog(context) {
			return new Promise((res) =>  {
				setTimeout(() => { context.commit('addOne'); res('111');}, 1000)
			});
		}
	}
}

// 创建Vuex.Store()
const store = new Vuex.Store({
	modules: {
		a: moduleA,
		default: defaultModule
	}
})

// 导出
export default store

