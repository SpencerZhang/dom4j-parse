package tech.wintercloud.parse;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.*;
import org.dom4j.tree.DefaultElement;
import org.junit.Test;
import tech.wintercloud.utils.ParseUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Spencer Chang
 * @date 2019-01-16 14:17
 */
public class Dom4jParseTest {
    private static final String XMLDATA = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
            "<packet>" +
            "<head>" +
            "<transCode>1</transCode>" +
            "<signFlag>2</signFlag>" +
            "<masterID>3</masterID>" +
            "<packetID>4</packetID>" +
            "<timeStamp>5</timeStamp>" +
            "</head>" +
            "<body>" +
            "<totalCount>6</totalCount>" +
            "<acctNo>7</acctNo>" +
            "<acctName>8</acctName>" +
            "<currency>9</currency>" +
            "<lists name=\"HistoryList\">" +
            "<list>" +
            "<voucherNo>10</voucherNo>" +
            "<seqNo>11</seqNo>" +
            "<txAmount>12</txAmount>" +
            "<balance>13</balance>" +
            "<tranFlag>14</tranFlag>" +
            "<transDate>15</transDate>" +
            "<transTime>16</transTime>" +
            "<note>17</note>" +
            "<remark>18</remark>" +
            "<payeeBankNo>19</payeeBankNo>" +
            "<payeeBankName>20</payeeBankName>" +
            "<payeeAcctNo>21</payeeAcctNo>" +
            "<payeeName>22</payeeName>" +
            "<transCode>23</transCode>" +
            "<branchId>24</branchId>" +
            "<customerAcctNo>25</customerAcctNo>" +
            "<payeeAcctType>26</payeeAcctType>" +
            "<transCounter>27</transCounter>" +
            "<authCounter>28</authCounter>" +
            "<otherChar10>29</otherChar10>" +
            "<otherChar40>30</otherChar40>" +
            "<seqNum>31</seqNum>" +
            "<revFlag>Y</revFlag>" +
            "</list>" +
            "</lists>" +
            "</body>" +
            "</packet>";
    private static Document document = null;
    static {
        try {
            document = DocumentHelper.parseText(XMLDATA);
        }catch (DocumentException e){
            e.printStackTrace();
        }

    }

    @Test
    public void convert() throws DocumentException {
        Document document = DocumentHelper.parseText(XMLDATA);
        assertTrue(document != null);
    }

    @Test
    public void getRootElement() throws DocumentException {
        Element element = document.getRootElement();
        System.out.println(element.toString());
    }

    @Test
    public void getNodeElements() throws DocumentException {
        Element element = document.getRootElement();
        Iterator<Element> heads = element.elementIterator("head");
        while (heads.hasNext()) {
            Element e = heads.next();
            System.out.println(e.getName());
            System.out.println(e.elementTextTrim("transCode"));
        }
    }

    @Test
    public void selectNodes4XPath() throws DocumentException {
        List<Node> nodes = document.selectNodes("//packet/head");
    }

    @Test
    public void selectNodesValue4XPath() throws DocumentException {
        Map<String,String> result = new HashMap<>(16);
        ParseUtil.selectNodesValue4XPath(document,"//packet/head",result);
        result.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
    }
    @Test
    public void selectNodesValueJson4XPath() throws DocumentException {
        JSONObject result = new JSONObject();
        Map<String,String> resultData = new HashMap<>(16);
        ParseUtil.selectNodesValue4XPath(document,"//packet/head",resultData);
        result.putAll(resultData);
        System.out.println(result.toJSONString());
    }
    @Test
    public void selectNodesValueJsonObject4XPath() throws DocumentException {
        JSONObject result = new JSONObject();
        Map<String,String> resultData = new HashMap<>(16);
        ParseUtil.selectNodesValue4XPath(document,"//packet/head",resultData);
        result.putAll(resultData);
        result.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
    }

    @Test
    public void selectSingleNode4XPath() throws DocumentException {
        Map<String,String> result = new HashMap<>(16);
        ParseUtil.selectSingleNodeValue4XPath(document,"//packet/head/transCode",result);
        result.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
    }
    @Test
    public void selectSingleNodeValueJson4XPath() throws DocumentException {
        JSONObject result = new JSONObject();
        Map<String,String> resultData = new HashMap<>(16);
        ParseUtil.selectSingleNodeValue4XPath(document,"//packet/head/transCode",resultData);
        result.putAll(resultData);
        System.out.println(result.toJSONString());
    }
    @Test
    public void selectSingleNodeValueJsonObject4XPath() throws DocumentException {
        JSONObject result = new JSONObject();
        Map<String,String> resultData = new HashMap<>(16);
        ParseUtil.selectSingleNodeValue4XPath(document,"//packet/head/transCode",resultData);
        result.putAll(resultData);
        result.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
    }
    @Test
    public void selectSingleNodeValue4XPath() throws DocumentException {
        Node node = document.selectSingleNode("//packet/head/transCode");
        System.out.println(node.getStringValue());
    }
}
