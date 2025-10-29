package CustomListners;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

public class TestNGIReport  implements IReporter{

        public void generateReport(
                List<XmlSuite> xmlSuites, List<ISuite> OrangeHRMTest, String outputDirectory) {
            String SuiteName = OrangeHRMTest.get(0).getName();
            System.out.println("SuiteName is : "+SuiteName);
        }
    }

