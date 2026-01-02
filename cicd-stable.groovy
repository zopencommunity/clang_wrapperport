node('linux') {
  stage ('Poll') {
    checkout([
      $class: 'GitSCM', branches: [[name: '*/main']], extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/clang_wrapperport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [
      string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/clang_wrapperport.git'),
      string(name: 'PORT_DESCRIPTION', value: 'Wrapper script which includes compiler with required flag along with zoslib [D[D[D[D[D[D[D[D[D[D[D[D[D[D[D[D[D[D[D[D[D[D[Dcompiler flags and zoslib params.'),
      string(name: 'BUILD_LINE', value: 'STABLE')
    ]
  }
}
