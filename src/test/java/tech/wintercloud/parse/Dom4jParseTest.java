package tech.wintercloud.parse;

import static org.junit.Assert.assertTrue;

import org.dom4j.*;
import org.dom4j.tree.DefaultElement;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @author Spencer Chang
 * @date 2019-01-16 14:17
 */
public class Dom4jParseTest {
    static final String XMLDATA = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
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

    @Test
    public void convert() throws DocumentException {
        Document document = DocumentHelper.parseText(XMLDATA);
        assertTrue(document != null);
    }

    @Test
    public void getRootElement() throws DocumentException {
        Document document = DocumentHelper.parseText(XMLDATA);
        Element element = document.getRootElement();
        System.out.println(element.toString());
    }

    @Test
    public void getNodeElements() throws DocumentException {
        Document document = DocumentHelper.parseText(XMLDATA);
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
        Document document = DocumentHelper.parseText(XMLDATA);
        List<Node> nodes = document.selectNodes("//packet/head");
    }

    @Test
    public void selectNodesValue4XPath() throws DocumentException {
        Document document = DocumentHelper.parseText(XMLDATA);
        List<Node> heads = document.selectNodes("//packet/head");

        for (int i = 0; i < heads.size(); i++) {
            DefaultElement element = (DefaultElement) heads.get(i);
            List<Node> nodes = element.content();
            for (int j = 0; j < nodes.size(); j++) {
                DefaultElement elementn = (DefaultElement) nodes.get(j);
                System.out.println(elementn.getName());
                System.out.println(elementn.getStringValue());
            }
        }
    }

    @Test
    public void selectSingleNode4XPath() throws DocumentException {
        Document document = DocumentHelper.parseText(XMLDATA);
        Node node = document.selectSingleNode("//packet/head/transCode");
        String key = node.getName();
        String val = node.getStringValue();
        System.out.println(key);
        System.out.println(val);
    }

    @Test
    public void selectSingleNodeValue4XPath() throws DocumentException {
        Document document = DocumentHelper.parseText(XMLDATA);
        Node node = document.selectSingleNode("//packet/head/transCode");
        System.out.println(node.getStringValue());
    }
}
