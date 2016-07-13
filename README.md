# soa-kumuluzee-app

*****************Comando para subir a aplicacao************************
java -cp target/classes:target/dependency/* com.kumuluz.ee.EeApplication

*****************Comando 'curl' para teste************************
curl -H content-type:application/json -d {\"teste\":\"123456\"} http://localhost:8080/rest