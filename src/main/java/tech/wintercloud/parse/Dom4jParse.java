package tech.wintercloud.parse;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.*;
import org.dom4j.tree.DefaultElement;
import tech.wintercloud.utils.ParseUtil;

import java.util.*;

/**
 * @author Spencer Chang
 * @date 2019-01-16 14:12
 */
public class Dom4jParse {
    /**
     * 默认初始化大小
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * 把xml数据转换为Document
     * @param xmlData
     * @return
     * @throws DocumentException
     */
    public static Document convert(String xmlData) throws DocumentException {
        return DocumentHelper.parseText(xmlData);
    }

    /**
     * 获取根节点
     * @param rootDocument
     * @return
     */
    public static Element getRootElement(Document rootDocument) {
        return rootDocument.getRootElement();
    }

    /**
     * 获取根节点下node对应的所有Element
     * @param rootElement
     * @param node
     * @return
     */
    public static Iterator<Element> getNodeElements(Element rootElement, String node) {
        return rootElement.elementIterator(node);
    }

    /**
     * 使用XPath表达式获取node集合
     * @param document
     * @param xPathExpressions
     * @return
     */
    public static List<Node> selectNodes4XPath(Document document,String xPathExpressions){
        return document.selectNodes(xPathExpressions);
    }

    /**
     * 使用XPath表达式获取node下所有标签值
     * @param document
     * @param xPathExpressions
     * @return
     */
    public static Map<String,String> selectNodesValue4XPath(Document document,String xPathExpressions){
        Map<String,String> result = new HashMap<>(DEFAULT_INITIAL_CAPACITY);
        ParseUtil.selectNodesValue4XPath(document,xPathExpressions,result);
        return result;
    }


    /**
     * 使用XPath表达式获取node下所有标签值
     * @param document
     * @param xPathExpressions
     * @return json string
     */
    public static String selectNodesValueJson4XPath(Document document,String xPathExpressions){
        JSONObject result = new JSONObject();
        Map<String,String> resultData = new HashMap<>(DEFAULT_INITIAL_CAPACITY);
        ParseUtil.selectNodesValue4XPath(document,xPathExpressions,resultData);
        result.putAll(resultData);
        return result.toJSONString();
    }


    /**
     * 使用XPath表达式获取node下所有标签值
     * @param document
     * @param xPathExpressions
     * @return JSONObject
     */
    public static JSONObject selectNodesValueJsonObject4XPath(Document document,String xPathExpressions){
        JSONObject result = new JSONObject();
        Map<String,String> resultData = new HashMap<>(DEFAULT_INITIAL_CAPACITY);
        ParseUtil.selectNodesValue4XPath(document,xPathExpressions,resultData);
        result.putAll(resultData);
        return result;
    }
    /**
     * 使用XPath表达式获取某一个node标签值
     * @param document
     * @param xPathExpressions
     * @return
     */
    public static Map<String,String> selectSingleNode4XPath(Document document, String xPathExpressions){
        Map<String,String> result = new HashMap<>(DEFAULT_INITIAL_CAPACITY);
        ParseUtil.selectSingleNodeValue4XPath(document,xPathExpressions,result);
        return result;
    }

    /**
     * 使用XPath表达式获取某一个node标签值
     * @param document
     * @param xPathExpressions
     * @return json string
     */
    public static String selectSingleNodeValueJson4XPath(Document document, String xPathExpressions){
        JSONObject result = new JSONObject();
        Map<String,String> resultData = new HashMap<>(DEFAULT_INITIAL_CAPACITY);
        ParseUtil.selectSingleNodeValue4XPath(document,xPathExpressions,resultData);
        result.putAll(resultData);
        return result.toJSONString();
    }

    /**
     * 使用XPath表达式获取某一个node标签值
     * @param document
     * @param xPathExpressions
     * @return JSONObject
     */
    public static JSONObject selectSingleNodeValueJsonObject4XPath(Document document, String xPathExpressions){
        JSONObject result = new JSONObject();
        Map<String,String> resultData = new HashMap<>(DEFAULT_INITIAL_CAPACITY);
        ParseUtil.selectSingleNodeValue4XPath(document,xPathExpressions,resultData);
        result.putAll(resultData);
        return result;
    }

    /**
     * 使用XPath表达式获取某一个node标签值
     * @param document
     * @param xPathExpressions
     * @return
     */
    public static String selectSingleNodeValue4XPath(Document document, String xPathExpressions){
        Node node = document.selectSingleNode(xPathExpressions);
        return node.getStringValue();
    }
}
