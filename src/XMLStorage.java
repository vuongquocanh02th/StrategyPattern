import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLStorage implements Storage{
    @Override
    public void store(User user) {
        try {
            // Tạo file XML
            File file = new File("user.xml");
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // Tạo phần tử root
            Element root = document.createElement("users");
            document.appendChild(root);

            // Tạo phần tử user
            Element userElement = document.createElement("user");
            root.appendChild(userElement);

            // Tạo và thêm phần tử name
            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(user.getName()));
            userElement.appendChild(name);

            // Tạo và thêm phần tử email
            Element email = document.createElement("email");
            email.appendChild(document.createTextNode(user.getEmail()));
            userElement.appendChild(email);

            // Ghi nội dung vào file XML
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(document);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(file);
            transformer.transform(source, result);

            System.out.println("Đã lưu người dùng vào file XML!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
