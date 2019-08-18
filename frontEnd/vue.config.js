module.exports = {
    devServer: {
        //端口号
        port: 8081,
        proxy: {
            '/api': {
                //要代理的后端地址
                target: "http://localhost:8080",
                changeOrigin: true,
                pathRewrite: {
                    //路径映射
                    '^/api': '/'
                }
            }
        }
    },
    publicPath: './'
}