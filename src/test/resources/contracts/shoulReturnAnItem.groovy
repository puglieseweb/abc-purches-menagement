import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/purchase-management-system/item/10001'
    }
    response {
        status 200
        body([
                status: 'ok'
        ])
        headers {
            contentType('application/json')
        }
    }
}