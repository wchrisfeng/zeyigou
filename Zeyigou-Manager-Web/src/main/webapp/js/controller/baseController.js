//品牌控制层：基本控制层 可以理解是一个模板 定义一些各个控制层都需要用到的组件
app.controller("baseController",function ($scope) {

    //自定义分页变量
    $scope.paginationConf = {
        currentPage: 1,				//当前页
        totalItems: 10,				//总记录数
        itemsPerPage: 10,			//每页大小
        perPageOptions: [10, 20, 30, 40, 50],  //分页下拉选项
        onChange: function(){
            //$scope.findByPage();//重新加载  普通分页
            $scope.search();     //带条件的分页
        }
    };

    //定义批量删除的ids数组
    $scope.selectIds=[];
    //8.选中需要删除的brand对象 将brand.id添加到selectIds数组中 作为参数传入后端
    $scope.updateSelection=(event,id)=>{
        //8.1)判断当前这行对象的id是否被选中
        if(event.target.checked){ //event.target:代表正在点击的复选框控件
            //8.2)将id添加到数组中
            $scope.selectIds.push(id);
        }else{
            //8.3)找到当前这行对象id在此数组中的下标
            let index = $scope.selectIds.indexOf(id);
            //8.4)移除当前选中的id
            /**
             * 参数1：代表需要移除元素的下标
             * 参数2：代表移除的个数
             */
            $scope.selectIds.slice(index,1);
        }
    };
});