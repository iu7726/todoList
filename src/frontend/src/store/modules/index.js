/**
 require.context(
 directory,  // 검색 폴더 위치
 useSubdirectories, // 1번 파라미터인 검색폴더 의 하위 폴더까지 전부 로드 할지 유무
 regExp // 파일 검색 정규 표현식
 );

 module 폴더(.)에 있는 모든 js 파일 로드, 하위폴더가 있으므로 true.
 */
const requireModule = require.context('.', true, /\.js$/);

const modules = {};

requireModule.keys().forEach(filename => {
    // module 폴더에 index.js 는 로드 파일이 아니므로 제외
    const isIndexJsFile = filename === './index.js';

    let rgx = /index/;
    const isFoloderIndex = rgx.test(filename);

    if (!isIndexJsFile && isFoloderIndex) {

        const moduleName = filename.split('/')[1];
        // 모듈 추가
        modules[moduleName] = { namespaced: true, ...requireModule(filename) };
    }


});

export default modules;
