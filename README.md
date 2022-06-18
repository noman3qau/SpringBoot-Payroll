# Payroll Backend Application in SpringBoot
This is Java base backend Application I have made in SpringBoot Framework with multiple rest APIs.

# Following are the list of Rest APIs

#Employee
curl -X GET localhost:8080/employees

curl -X GET localhost:8080/employees/{id}

curl -v -X POST localhost:8080/orders -H 'Content-Type:application/json' -d '{"name":"Noman","role":"Java developer"}'

curl -X DELETE localhost:8080/employees/{id}


#Order
curl -X GET localhost:8080/oders

curl -X GET localhost:8080/employees/{id}

curl -v -X POST localhost:8080/orders -H 'Content-Type:application/json' -d '{"description":"Samsung","status":"IN_PROGRESS"}'

curl -X PUT localhost:8080/orders/5/complete

curl -X PUT localhost:8080/orders/4/cancel
