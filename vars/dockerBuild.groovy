def call(String dockerHubUsername, String imageName) {
    // Build the Docker image

            sh "docker build --progress=plain --build-arg REACT_APP_RAPID_API_KEY=your_key -t ${dockerHubUsername}/${imageName}:latest ."
     // Tag the Docker image
    sh "docker tag ${dockerHubUsername}/${imageName}:latest ${dockerHubUsername}/${imageName}:latest"
    
    // Push the Docker image
  withDockerRegistry([credentialsId: 'docker']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
    }
}
