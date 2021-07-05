import axios from "axios";

const client = axios.create();

/* 글로벌 설정
    // API 주소
    client.defaults.baseURL = "https://external-api-server.com/"

    // 헤더 설정
    client.defaults.headers.common["Authorization"] = "Bearer a1b2c3d4";

    // 인터셉터 설정
    axios.intercepter.response.use({
        response => {
            // 요청 성공 시 특정 작업 수행
            return response;
        },
        error => {
            // 요청 실패 시 특정 작업 수행
            return Promise.reject(error);
        }
    })
*/
// Add a request interceptor
// axios.interceptors.request.use(function (config) {
//     const token = localStorage.getItem("user");
//     config.headers.Authorization =  token;

//     return config;
// });

export default client;
