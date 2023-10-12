package nz.lab.contract.base

import io.restassured.module.mockmvc.RestAssuredMockMvc
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder
import pl.dziedziul.contractsincustomsourceset.Application
import pl.dziedziul.contractsincustomsourceset.CarResource
import spock.lang.Specification

@Slf4j
@DirtiesContext
@AutoConfigureMessageVerifier
@ContextConfiguration(classes = Application)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class ContractSpringTestBase extends Specification {
    @Autowired
    CarResource controller


    def setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(controller)
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder)
    }
}
