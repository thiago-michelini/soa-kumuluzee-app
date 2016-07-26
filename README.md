# soa-kumuluzee-app

*****************Comando para subir a aplicacao************************
java -cp target/classes:target/dependency/* com.kumuluz.ee.EeApplication

*****************Comando 'curl' para teste************************
curl -H content-type:application/json -d {\"teste\":\"123456\"} http://localhost:8080/rest

*****************Script para alterar usuario e senha do BD, fazer o build e subir a aplicacao************************
USER_PG=postgres;PW_PG=senha_pg;USER_HSQL=sa;PW_HSQL=senha_h;sed -i 's/name="javax.persistence.jdbc.user" value="adm_sgv"/name="javax.persistence.jdbc.user" value="'"$USER_PG"'" \/>/;s/name="javax.persistence.jdbc.password" value="adm_sgv"/name="javax.persistence.jdbc.password" value="'"$PW_PG"'" \/>/;s/name="javax.persistence.jdbc.user" value="sa"/name="javax.persistence.jdbc.user" value="'"$USER_HSQL"'" \/>/;s/name="javax.persistence.jdbc.password" value=""/name="javax.persistence.jdbc.password" value="'"$PW_HSQL"'" \/>/' ./src/main/resources/META-INF/persistence.xml;mvn clean install;java -cp ./target/classes:./target/dependency/* com.kumuluz.ee.EeApplication