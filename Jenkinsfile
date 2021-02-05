node {	
    // reference to maven
    // ** NOTE: This 'maven-3.6.1' Maven tool must be configured in the Jenkins Global Configuration.   
    def mvnHome = tool 'maven-3.6.1'

    // holds reference to docker image
    def dockerImage
    // ip address of the docker private repository(nexus)
    
    def dockerRepoUrl = "localhost:5000"
    def dockerImageName = "prj-teste-my-batis"
    def dockerImageTag = "${dockerRepoUrl}/${dockerImageName}:${env.BUILD_NUMBER}"

    stage('Clone Repo') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/marciogreison/PrjTesteMyBatis.git'
      // Get the Maven tool.
      // ** NOTE: This 'maven-3.6.1' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'maven-3.6.1'
    }    
  
    stage('Tests') {
       sh "'${mvnHome}/bin/mvn' clean test"
    }

    stage('Build Project') {
      // build project via maven
      sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
    }
	
    //stage('Publish Tests Results'){
      //parallel(
        //publishJunitTestsResultsToJenkins: {
          //echo "Publish junit Tests Results"
	//	  junit '**/target/surefire-reports/TEST-*.xml'
	//	  archive 'target/*.jar'
        //},
        //publishJunitTestsResultsToSonar: {
        //  echo "This is branch b"
      //})
    //}	
    stage('Build Docker Image') {
      // build docker image
      sh "whoami"
      sh "ls -all /var/run/docker.sock"
      sh "mv ./target/PrjTesteMyBatis*.jar ./data" 
      
      dockerImage = docker.build("prj-teste-my-batis")
    }
   
    stage('Deploy Docker Image'){
      
      // deploy docker image to nexus

      echo "Docker Image Tag Name: ${dockerImageTag}"

      sh "docker login -u registry -p registry ${dockerRepoUrl}"
      sh "docker tag ${dockerImageName} ${dockerImageTag}"
      sh "docker push ${dockerImageTag}"
      
      sh "docker stack deploy ${dockerImageName} -c docker-compose.yml"      
    }
    
}
