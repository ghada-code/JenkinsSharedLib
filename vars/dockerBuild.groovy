def call(String dockerHubUsername, String imageName) {
    sh "echo "dockerHubUsername: ${dockerHubUsername}, imageName: ${imageName}""

sh """
    sudo docker build \
    --progress=plain \
    --build-arg REACT_APP_RAPID_API_KEY=3018c17b5cmsh11257f7e0e72c98p1971ebjsnc60e36e3adde \
    -t ${dockerHubUsername}/${imageName}:latest .
"""

    withDockerRegistry(credentialsId: 'docker') {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
