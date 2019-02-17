node {
    def mvnHome
    mvnHome = tool 'Maven_3_6_0'
    def build_ok = true

    stage('Fetch sources and build sources') {
        //get sources
        git 'https://github.com/steevessaillant/TDDJavaValueInverterKata'
        //maven compile
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' compile -Dmaven.test.failure.ignore=true"
        } else {
            bat(/"${mvnHome}\bin\mvn" compile -Dmaven.test.failure.ignore=true/)
        }

    }

    try{
        stage('Test') {
            //maven test
            propagate: false
            if (isUnix()) {
                sh "'${mvnHome}/bin/mvn' test "
            } else {
                bat(/"${mvnHome}\bin\mvn" test/)
            }

        }
    }
    catch(e) {
            build_ok = false
            echo e.toString()
    }


    stage('JUnit unit-test report'){
        always {
                junit '**/surefire-reports/*.xml'
              }
    }

    stage('Cucumber functional tests report') {
            cucumber buildStatus: 'UNSTABLE',
                    fileIncludePattern: '**/cucumber.json',
                    trendsLimit: 10,
                    classifications: [
                        [
                            'key': 'Browser',
                            'value': 'Chrome'
                        ]
                    ]
        }
    stage('Deploy') {

        //maven deploy to nexus
        //if (isUnix()) {
        //    sh "'${mvnHome}/bin/mvn' package "
        //} else {
        //    bat(/"${mvnHome}\bin\mvn" package/)
        //}
        echo "This stage is commented out for now!"
    }
    if(build_ok) {
            currentBuild.result = "SUCCESS"
        } else {
            currentBuild.result = "UNSTABLE"
        }
}

