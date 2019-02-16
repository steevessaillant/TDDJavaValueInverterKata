node {
    def mvnHome
    mvnHome = tool 'Maven_3_6_0'
    stage('Fetch sources and build sources') {
        //get sources
        git 'https://github.com/steevessaillant/TDDJavaValueInverterKata'
        //maven compile
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' clean install"
        } else {
            bat(/"${mvnHome}\bin\mvn" clean install/)
        }

    }

    stage('Test') {
        //maven test
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' verify "
        } else {
            bat(/"${mvnHome}\bin\mvn" verify/)
        }

    }
    stage('Deploy') {

        maven compile
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' package "
        } else {
            bat(/"${mvnHome}\bin\mvn" package/)
        }
        echo "This stage is commented out for now!"
    }
}

