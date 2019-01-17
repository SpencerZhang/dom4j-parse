package tech.wintercloud.utils;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.tree.DefaultElement;

import java.util.List;
import java.util.Map;

/**
 * @author Spencer Chang
 * @date 2019-01-17 10:02
 */
public class ParseUtil {

    /**
     * 使用XPath表达式获取node下所有标签值,公共处理方法
     * @param document
     * @param xPathExpressions
     * @param result
     */
    public static void selectNodesValue4XPath(Document document, String xPathExpressions,Map<String,String> result){
        List<Node> nodes = document.selectNodes(xPathExpressions);
        for (int i = 0; i < nodes.size(); i++) {
            DefaultElement element = (DefaultElement)nodes.get(i);
            List<Node> subNodes = element.content();
            for (int j = 0; j < subNodes.size(); j++) {
                DefaultElement subElement = (DefaultElement)subNodes.get(j);
                String key = subElement.getName();
                String val = subElement.getStringValue();
                result.put(key,val);
            }
        }
    }

    /**
     * 使用XPath表达式获取某个node标签值,公共处理方法
     * @param document
     * @param xPathExpressions
     * @param result
     */
    public static void selectSingleNodeValue4XPath(Document document, String xPathExpressions,Map<String,String> result){
        Node node = document.selectSingleNode(xPathExpressions);
        String key = node.getName();
        String val = node.getStringValue();
        result.put(key,val);
    }
}
