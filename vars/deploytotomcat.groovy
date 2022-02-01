def call(ip,credid){
   sshagent([credid]) {
    // copy tomcat to webhook location
     sh "scp -o StrictHostKeyChecking=no target/javademoproject.war ubuntu@${ip}:/opt/tomcat/webapps/javademoproject.war"
     sh "ssh ubuntu@${ip}  /opt/tomcat/bin/shutdown.sh"
     sh "ssh ubuntu@${ip}  /opt/tomcat/bin/startup.sh"
    }
  echo "deploy to tomcat on ip ${ip}"
}
