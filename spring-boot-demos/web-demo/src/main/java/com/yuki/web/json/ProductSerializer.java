package com.yuki.web.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.TextNode;
import com.yuki.web.entity.Product;
import com.yuki.web.entity.User;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/*
 * 使用@JsonComponent来定义JsonSerializer/JsonDeserializer
 * */
@JsonComponent
public class ProductSerializer {

    // ProductSerializer
    public static class Serializer extends JsonSerializer<Product> {
        @Override
        public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject(); // 写括号
            jsonGenerator.writeStringField("fields",product.getName() + "-" + product.getPrice()); // 写内容
            jsonGenerator.writeEndObject(); // 写括号
        }
    }

    // ProductDeserializer
    public static class Deserializer extends JsonDeserializer<Product> {

        @Override
        public Product deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            // 1. 解析成tree
            TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
            // 2. 序列化
            TextNode fields = (TextNode)treeNode.get("fields");
            String[] split = fields.asText().split("-");
            // 3. 返回对象
            return new Product(split[0],split[1]);
        }
    }
}
