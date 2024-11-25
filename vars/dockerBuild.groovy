def call(String dockerHubUsername, String imageName) {
    // Login to Docker Hub
    withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh """
            echo "$DOCKER_PASSWORD" | sudo docker login -u "$DOCKER_USERNAME" --password-stdin
        """
    }

    // Build the Docker image
    sh """
        sudo docker build \
        --progress=plain \
        --build-arg REACT_APP_RAPID_API_KEY=3018c17b5cmsh11257f7e0e72c98p1971ebjsnc60e36e3adde \
        -t ${dockerHubUsername}/${imageName}:latest .
    """

    // Debugging output
    sh "echo 'dockerHubUsername: ${dockerHubUsername}, imageName: ${imageName}'"

    // Push the Docker image
    withDockerRegistry([credentialsId: 'docker']) {
        sh "sudo docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
