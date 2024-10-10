curl -X POST http://localhost:8080/Person/add \
-H "Content-Type: application/json" \
-d '{
    "firstName" : "Zarif",
    "lastName" : "Khan",
    "weight" : 104,
    "height" : 167
}'


curl -X GET http://localhost:8080/Person/getAll
