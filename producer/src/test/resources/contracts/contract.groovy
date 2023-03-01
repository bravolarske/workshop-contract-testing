package contracts
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return hat by id=1"

    request {
        url "/api/meal-vouchers/10"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body([
                amount : 80,
                endDate: "1996-12-02"
        ])
    }
}