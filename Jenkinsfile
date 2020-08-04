pipeline{

	agent {
		docker{
			label 'docker:linux'
			image 'alpine'
		}
	}

	stages{
		stage('Test') {
			steps{
				sh 'echo hello'
			}
		}
	}
}