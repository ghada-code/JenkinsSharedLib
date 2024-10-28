def call(){
    sh 'docker stop App'
    sh 'docker rm App'
}