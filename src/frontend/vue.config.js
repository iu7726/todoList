const path = require('path')

module.exports = {
    outputDir:path.resolve(__dirname, "../"+"main/resources/static"),
    devServer: {
        proxy: {
            '/api' : {
                target: "http://localhost:3000",
                ws:true,
                changeOrigin: true
            },
        }
    }
}