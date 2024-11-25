def call(String dockerHubUsername, String imageName) {
    // Build the Docker image with progress and the build argument for the API key
    sh """
        docker build --progress=plain --build-arg REACT_APP_RAPID_API_KEY=3018c17b5cmsh11257f7e0e72c98p1971ebjsnc60e36e3adde -t ${dockerHubUsername}/${imageName}:latest .
    """
    
    // Push the Docker image to Docker Hub with the correct credentials
    withDockerRegistry([credentialsId: 'docker']) {
        sh """
            docker push ${dockerHubUsername}/${imageName}:latest
        """
    }
}
