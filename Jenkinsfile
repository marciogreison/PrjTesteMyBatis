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
      env.GIT_TAG_NAME = gitTagName()
      //env.GIT_TAG_MESSAGE = gitTagMessage()	    
	    
      //echo "GIT_TAG_NAME: ${env.GIT_TAG_NAME}"
      //echo "GIT_TAG_MESSAGE: ${env.GIT_TAG_MESSAGE}"    	    
      
	//dockerImageTag = "${dockerRepoUrl}/${dockerImageName}:${env.GIT_TAG_NAME}"
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
    }

}

/** @return The tag name, or `null` if the current commit isn't a tag. */
String gitTagName() {
    commit = getCommit()
    if (commit) {
        desc = sh(script: "git describe --tags ${commit}", returnStdout: true)?.trim()
        if (isTag(desc)) {
            return desc
        }
    }
    return null
}

/** @return The tag message, or `null` if the current commit isn't a tag. */
String gitTagMessage() {
    name = gitTagName()
    msg = sh(script: "git tag -n10000 -l ${name}", returnStdout: true)?.trim()
    if (msg) {
        return msg.substring(name.size()+1, msg.size())
    }
    return null
}

String getCommit() {
    return sh(script: 'git rev-parse HEAD', returnStdout: true)?.trim()
}

@NonCPS
boolean isTag(String desc) {
    match = desc =~ /.+-[0-9]+-g[0-9A-Fa-f]{6,}$/
    result = !match
    match = null // prevent serialisation
    return result
}
