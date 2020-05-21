/**
 * 校外客户信息列表
 */

//设置全局表单提交格式
Vue.http.options.emulateJSON = true;

// Vue实例
var vm = new Vue({
    el: '#app',
    data() {
        return {
            //element-ui的table需要的参数必须是Array类型的
            projects: [{
                No: '',
                name: '',
                students_num: '',
                company_teacher: '',
                company_teacher_title: '',
                release_date: '',
                audit_date: '',
                end_date: '',
                summary: '',
                grade: '',
                major: ''
            }],


            //添加dialog
            showSave: false,
            //编辑dialog
            showEditor: false,

            //条件查询单独封装的对象
            searchEntity: {},



            //分页选项
            pageConf: {
                //设置一些初始值(会被覆盖)
                pageCode: 1, //当前页
                pageSize: 6, //每页显示的记录数
                totalPage: 12, //总记录数
                pageOption: [6, 10, 20], //分页选项
            },

            loading: {},

            created() {
                // this.findAll();
                this.search(this.pageConf.pageCode, this.pageConf.pageSize);
                this.loadings(); //加载动画
            },
        }
    },





});
