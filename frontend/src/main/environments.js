const dev = {
    "backendUrl":"http://localhost:9999"
}

const azure = {
    "backendUrl":"https://posting-ms.azurewebsites.net/"
}

const config = process.env.REACT_APP_PROFILE && process.env.REACT_APP_PROFILE === 'dev' ? dev : azure;  

export default {
    ...config
}