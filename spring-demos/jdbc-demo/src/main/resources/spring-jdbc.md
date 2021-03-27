## 🌲 spring - jdbc 

### 🍁 spring - jdbc - 简介

`Spring-Jdbc`是对`Jdbc的封装`，解决了Jdbc的如下问题

- `简化了调用流程`(采用模版设计模式封装)
- `异常转换`，使用`ErrorCodeSqlExceptionTranslator`把`SQLException(检查异常)`转换成`RuntimeException(非检查异常)`
- 把`Connection绑定到当前线程`(ThreadLoal方式)，保证了`Connection是线程安全`的

### 🍂 spring - jdbc - API

在使用时候，大概分为三类使用方法，分别是

- `模板方式` - `JdbcTemplate`和`NamedParamterTemplate`
- `Support类方式` - `JdbcDaoSupport`
- `简化和复用对象(不用写sql,可以复用)` - `SimpleJdbcInsert`、`SimpleJdbcCall`、`SqlMappingQuery`、`SqlUpdate`

`JdbcTemplate` -  查询

- execute() - 执行DDL或者其他SQL
- `query()` - 执行DQL。一般用于`查询多行并传给BeanPropertyRowMapper`
- `queryForObject` - 查询单行单列或者单行多列。
- `queryForList` - 查询多行，返回的类型是`List<Map<k,v>>`。
- update() - 执行更新。配合`PreparedStatementCreator`和`GeneratedKeyHolder`可以获取`自增主键`
- batchUpdate - 批量更新。使用List或者`BatchUpdateStatementSetter`传入参数。

`NamedParamterTemplate` - 支持命名参数SqlParamter

- query() - 更新。可以传入SqlParamterSource
- batchUpdate() - 批量更新。使用SqlParamterSourceUtils传入参数

`MapSqlParamterSource` - 把Map封装成SqlParamterSource

`BeanPropertySqlParamterSource` - 把Bean封装成SqlParamterSource

`JdbcDaoSupport` - 内部有JdbcTemplate，可以继承它

`SimpleJdbcInsert` - 执行插入，可以不用写Sql

- withTableName() - 表名
- usingGeneratedKeyColumns - 自增主键
- execute() - 插入
- executeAndReturnKeyHolder - 插入并返回KeyHolder

`SimpleJdbcCall` - 调用存储过程、函数

- withProcedureName() - 指定存储过程
- withFunctionName() - 指定函数
- execute() - 执行

`SqlMappingQuery` - 可复用查询(可以直接封装到DAO中)

- setsql() - 指定sql
- setDataSource() - 指定datasource
- comiple() - 编译

`SqlUpdate` - 可复用更新

- declareParamter() - 声明参数



## 🌳 Spring -jdbc - datasource

Spring提供了datasource的实现，`测试时候使用很方便`。

- `DriverManagerDatasource` - 每次获取新的连接
- `SingleConnectionDatasource` - 只有一个连接(线程安全问题，只能做测试)
- `DataSourceUtils` - 获取连接，然后把连接绑定到线程(TransiactionManager和JdbcTemplate使用它)

## 🍀 Spring - jdbc - template

### 🌱 JdbcTempalte使用

```java
@Service
public class AreaService {
    // 注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

  
    /**
    * queryForObject - 查询单行
    */ 
    public int count() {
        // 1. 查询
        Integer integer = jdbcTemplate.queryForObject("select count(*) from tb_area where id > ?", Integer.class, 1);
        // 2. 返回
        return integer;
    }


    /*
     * query - 查询多行，配合BeanPropertyRowMapper完成结果集映射
     * */
    public List<Area> queryAreaById() {
        // 1. 查询
        List<Area> area = jdbcTemplate.query("select * from tb_area where id > 1", BeanPropertyRowMapper.newInstance(Area.class));
        // 2. 返回
        return area;
    }


    /*
     * queryForList - 查询多行，返回List<Map<String,Object>>
     * */
    public List<Map<String,Object>> queryAreaList() {
        // 1. 查询
        final List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tb_area where id= 1");
        // 2. 返回
        return list;
    }


    /*
     * update - 插入，配合PreparedStatementCreator和GenderatedKeyHolder - 获取自增主键
     * */
    public int insert() {
        // 1. 创建KeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        // 2. 执行查询
        int update = jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                // 这里设置了获取哪个column作为primarykey
                PreparedStatement ps = con.prepareStatement("insert into tb_area values(null,'南aa校区',0,?,?)",new String[] {"id"});
                ps.setDate(1, new Date(2021, 1, 1));
                ps.setDate(2, new Date(2021, 1, 1));
                return ps;
            }
        }, keyHolder);
        // 3. 返回自增主键
        return keyHolder.getKey().intValue();
    }


    /*
     * batchUpdate - 批量更新 - 使用BatchPreparedStatementSetter设置param
     * */
    public void batchUpdate() {
        // 1. 创建参数
        final List<Integer> idList = new ArrayList<Integer>();
        idList.add(1);
        // 2. 传参，查询
        jdbcTemplate.batchUpdate("update tb_area set priority = ? where id = ?", new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1,40);
                ps.setInt(2,idList.get(i));
            }
            public int getBatchSize() {
                return idList.size();
            }
        });
    }


    /*
     * batchUpdate - 参数传递 - 直接传入
     * */
    public void batchUpdate2() {
        final List<Object[]> paramList = new ArrayList<Object[]>();
        paramList.add(new Object[]{41,1});
        jdbcTemplate.batchUpdate("update tb_area set priority = ? where id = ?",paramList);
    }
}
```

### 🌴 NamedJdbcTemplate使用

支持命名参数，可以使用`MapSqlParamterSource`、`BeanPropertyParamterSource`、`SqlParamterSourceUtils`传入。

```java
@Service
public class AreaServiceNamed {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;


    /*
     * update - 可以接收Map和SqlParamterSource、MapSqlParamterSource、BeanPropertySqlParamterSource
     * */
    public void insert() {
        // 1. 创建参数
        Area area = new Area();
        area.setId(1l);
        area.setPriority(12);
        BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(area);
        // 2. 执行查询
        namedJdbcTemplate.update("update tb_area set priority=:priority where id = :id",paramSource);
    }


    /*
    * 批量更新 - SqlParamterUtils、SqlParamterSource
    * */
    public void batchUpdate() {
        // 1. 尊卑参数
        Area area1 = new Area();
        Area area2 = new Area();
        area1.setId(1l);
        area1.setPriority(13);
        area2.setId(2l);
        area2.setPriority(13);
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(new Object[]{area1,area2});
        // 2. 执行查询
        namedJdbcTemplate.batchUpdate("update tb_area set priority=:priority where id = :id",batch);
    }
}
```

## 🍃 spring - jdbc - JdbcDaoSpuport

```java
@Service
public class AreaServiceSupport extends JdbcDaoSupport  {

    @Autowired
    public AreaServiceSupport(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
    }

    /*
     * 使用 JdbcDaoSupport - 使用和JdbcTemplate一样
     * */
    public int count() {
        // 1. 查询
        Integer integer = super.getJdbcTemplate().queryForObject("select count(*) from tb_area where id > ?", Integer.class, 1);
        // 2. 返回
        return integer;
    }
}
```

## 🌿 spring - jdbc - simpleJdbc和sqlQuery和SqlUpdate

### 🌻 SimpleJdbcInsert

```java
/*
* 插入
* withTableName()
* usingGenderateKeyColumns()
* execute()
* executeAndReturnKey()
* */
public int insert() {
    // 1. 生成SimpleJdbcInsert
    SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(dataSource)
        .withTableName("tb_area") // 表名称
        .usingGeneratedKeyColumns("id"); // 自增主键
    // 2. 执行
    HashMap<String, Object> params = new HashMap();
    params.put("name","哈哈哈aa");
    params.put("create_time",new Date());
    params.put("update_time",new Date());
    params.put("priority",1);
    KeyHolder keyHolder = simpleInsert.executeAndReturnKeyHolder(params);
    // 3. 返回
    return keyHolder.getKey().intValue();
}

```

### 🌼 SimpleJdbcCall

```java
 /*
* SimpleJdbcCall -
 * */
public  void executeCall(String[] args) {
    SimpleJdbcCall area_query = new SimpleJdbcCall(dataSource).withProcedureName("area_query");// 指定存储过程名称
    MapSqlParameterSource paramSource = new MapSqlParameterSource()
        .addValue("id",1);
    Map<String, Object> res = area_query.execute(paramSource);
}
```

### 🌹 SqlMappingQuery

```java
/*
* 查询
**/
public List queryList() {
    // 1. 执行查询
    MappingSqlQuery mappingSqlQuery = new MappingSqlQuery<Area>(dataSource,"select * from tb_area where id > 1") {
        protected Area mapRow(ResultSet rs, int rowNum) throws SQLException {
            return BeanPropertyRowMapper.newInstance(Area.class).mapRow(rs,rowNum);
        }

    };
    List list = mappingSqlQuery.execute();
    // 2. 返回列表
    return list;
}
```

### 🌷 SqlUpdate

```java
/*
* 更新 -
**/
public void updateById() {
    // 1. 传入sql
    SqlUpdate sqlUpdate = new SqlUpdate(dataSource, "update tb_area set priority=? where id =?");
    sqlUpdate.declareParameter(new SqlParameter("priority",Types.NUMERIC));
    sqlUpdate.declareParameter(new SqlParameter("id",Types.NUMERIC));
    sqlUpdate.compile();
    // 2. 执行查询
    int update = sqlUpdate.update(48, 1);
}
```

### 🌺 复用 - 封装成DAO

```java
@Component
public class AreaDao {
    @Autowired
    public AreaDao(DataSource dataSource) {
        this.dataSource = dataSource;
        list = new SqlQueryDao<Area>(dataSource,"select * from tb_area",Area.class);
        query = new SqlQueryDao<Area>(dataSource,"select * from tb_area where id = ?",Area.class);
        insert = new SimpleJdbcInsert(dataSource).withTableName("tb_area").usingGeneratedKeyColumns("id");
        update = new SimpleJdbcInsert(dataSource).withTableName("tb_area");
        delete = new SqlUpdate(dataSource,"delete from tb_area where id =?");
    }


    private DataSource dataSource;
    // 查询 - 列表
    SqlQueryDao<Area> list;
    // 查询 - 单条
    SqlQueryDao<Area> query;
    // 插入
    SimpleJdbcInsert insert;
    // 更改 - 传入id
    SimpleJdbcInsert update;
    // 删除 -
    SqlUpdate delete;
}
// 用于查询
class SqlQueryDao<T> extends MappingSqlQuery<T>{

    private Class<T> t;

    public SqlQueryDao(DataSource ds, String sql,Class<T> t) {
        super(ds, sql);
        compile();
        this.t = t;
    }

    @Override
    protected T mapRow(ResultSet rs, int rowNum) throws SQLException {
        return BeanPropertyRowMapper.newInstance(t).mapRow(rs,rowNum);
    }
}
```

使用如下

```java 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-jdbc.xml"})
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQuery() {
        List<Area> execute = areaDao.list.execute();
        System.out.println(execute);
    }
}
```

## 🍖参考连接

[🍖 使用JDBC实现数据访问](https://www.bookstack.cn/read/spring-5-framework-doc/15-15.md)

>  