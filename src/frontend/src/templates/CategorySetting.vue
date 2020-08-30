<template>
    <div class="categorySetting">
        <div class="header">
            <div class="header-text">카테고리 설정</div>
            <v-btn cls="add-close" @btnClick="popClose">X</v-btn>
        </div>
        <div>
            <div>
                선택 : 
                <select v-model="pickCate">
                    <option v-for="cate in list" :value="cate.id" :key="'cate_list_'+cate.id">{{cate.cate_name}}</option>
                </select>
            </div>

            <div>
                 <v-input :val="cateName" @input="cateNameInput"/>
            </div>

            <div>
                <v-btn cls="save-btn" @btnClick="addCategory">추가하기</v-btn>
                <v-btn cls="save-btn" @btnClick="modCategory">수정하기</v-btn>
                <v-btn cls="del-btn" @btnClick="delCategory">삭제하기</v-btn>
            </div>
        </div>
    </div>
</template>

<script>
import Btn from "@/components/Btn";
import Input from "@/components/Input";

import { mapActions } from "vuex";

export default {
    name:"CategorySetting",
    props:['list'],
    components:{
        'v-btn':Btn,
        'v-input' : Input,
    },
    data(){
        return {
            pickCate:-1,
            cateName:"",
        }
    },
    watch:{
        pickCate(val){
            let cateObj = this.list.filter(i => i.id == val)[0];
    
            this.cateName = cateObj.cate_name
        }
    },
    methods: {
        ...mapActions({
            addCate:'mainFix/addCate',
            modCate:"mainFix/modCate",
            delCate:"mainFix/delCate"
        }),
        popClose(){
            this.pickCate = -1;
            this.cateName = "";
            this.$emit('popClose');
        },

        cateNameInput(event){
            this.cateName = event;
        },

        addCategory(){

            if(!confirm("추가하시겠습니까?")) return false;

            let data = {
                'cate_name':this.cateName,
                'users_id':1
            }

            this.addCate(data);

            this.popClose();
        },

        modCategory(){

            if(!confirm("수정하시겠습니까?")) return false;

            let data = {
                'id':this.pickCate,
                'cate_name':this.cateName
            }

            this.modCate(data);

            this.popClose();
        },

        delCategory(){

            if(this.pickCate < 1) {
                alert("삭제할 카테고리를 선택해주세요.");
                return false;
            }

            if(!confirm("삭제하시겠습니까?")) return false;

            let data = {
                'id':this.pickCate
            }
            this.delCate(data);

            this.popClose();
        }
    }
}
</script>

<style lang="scss" scoped>
    .categorySetting {
        position: absolute;
        background: #fff;
        top: 17%;
        left: 34%;
        width: 41%;
        height: 11vh;
        border: 1px solid #000;
        z-index: 2;
        min-height: 138px;
        overflow-y: auto;
        z-index: 10;

        .header{
            background: #2c3e50;
            color: #fff;
            font-weight: bold;
            text-align: left;
            width: 100%;
            height: 3vh;

            .header-text{
                float:left;
            }
        }
    }
</style>