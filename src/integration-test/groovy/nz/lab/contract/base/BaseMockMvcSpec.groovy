package nz.lab.contract.base

import io.restassured.module.mockmvc.RestAssuredMockMvc
import pl.dziedziul.contractsincustomsourceset.CarResource
import spock.lang.Specification

/**
 * Created by Nigel.Zheng on 10/12/2023.
 *
 * @author Nigel.Zheng
 */
abstract class BaseMockMvcSpec extends Specification {
    def setup() {
        RestAssuredMockMvc.standaloneSetup(new CarResource())
    }

    void isProperCorrelationId(Integer correlationId) {
        assert correlationId == 123456
    }

    void isEmpty(String value) {
        assert value == null
    }
}
