package ua.home.springboot.sample.di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.home.springboot.Application;
import ua.home.springboot.sample.xml.XmlProcessor;
import ua.home.springboot.sample.xml.XmlProcessorImpl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class DependencyInjectionTest {
//    @Value("${local.server.port}")
//            int port=8035;

    //DI
    @Autowired
    XmlProcessor xmlProcessor;

    @Test
    public void test_sec_always_return_true() {

//        assert correct type/impl
        assertThat(xmlProcessor, instanceOf(XmlProcessorImpl.class));

//        assert true
        assertThat(xmlProcessor.isValid(""), is(true));

    }


}
