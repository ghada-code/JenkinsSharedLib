def call(){
    sh 'sudo docker stop App'
    sh 'sudo docker rm App'
}