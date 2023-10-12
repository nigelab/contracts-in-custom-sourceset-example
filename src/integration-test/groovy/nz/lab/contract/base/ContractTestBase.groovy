package nz.lab.contract.base

import io.restassured.module.mockmvc.RestAssuredMockMvc
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import pl.dziedziul.contractsincustomsourceset.Application
import spock.lang.Specification

@WebMvcTest
@Slf4j
@ContextConfiguration(classes = Application)
abstract class ContractTestBase extends Specification {
    @Autowired
    private MockMvc mockMvc


    def setup() {
        RestAssuredMockMvc.mockMvc(mockMvc)
    }
}
