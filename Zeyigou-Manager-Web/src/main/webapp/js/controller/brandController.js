//Controller层 负责与前端打交道
//需要注意的是 这里的第一个回调函数不能使用简易语法 否则会报错 其它地方可以使用简易语法
app.controller("brandController",function ($scope,$controller,brandService) {
    //需要继承baseController
    $controller('baseController',{$scope:$scope});//继承
    //3.定义方法 查询所有品牌信息
    $scope.findAll=()=>{
        //3.1)向后端发送请求
        brandService.findAll().success(resp=>{
            //3.2)接收后端传来的参数
            $scope.brandList = resp;
        })
    };

    //4.分页查询品牌信息
    $scope.findByPage=()=>{
        //4.1)将当前页与当前页显示的记录数传到后端
        brandService.findByPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage).success(
            resp=>{
                //4.2)返回总记录数
                $scope.paginationConf.totalItems = resp.total;
                //4.3)通过回调 获取后端返回的记录数
                $scope.brandList = resp.rows;
            }
        )
    };

    //5.带条件的分页查询
    $scope.search=()=>{
        brandService.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.searchEntity).success(resp=>{
            //5.1)返回总记录数
            $scope.paginationConf.totalItems = resp.total;
            //5.2)通过回调 获取后端返回的记录数
            $scope.brandList = resp.rows;
        })
    };

    //6.修改品牌
    $scope.updateUI=(brand)=>{
        $scope.entity = brand;   //将当前正在遍历的品牌对象赋值给entity对象
    };

    //7.保存品牌信息
    /**
     *(因为添加品牌这个entity对象直接与click进行绑定 当点击事件的时候entity对象就有值)
     * 且添加页面与修改页面使用的是同一个编辑页面 所以根据entity对象有没有id这个属性
     * 如果没有 说明是添加页面 如果有 说明是执行修改操作
     */
    $scope.save=()=>{
        //7.1)定义url
        let url = "../brand/add.do";
        //7.2)判断id是否存在
        if($scope.entity.id){
            url = "../brand/update.do";
        }
        //7.3)向后端发送请求
        brandService.save(url,$scope.entity).success(resp=>{
            //7.4)判断 如果返回结果为真 说明修改/添加品牌成功
            if(resp.success){
                $scope.search();
            }else{
                alert(resp.message); //修改/添加品牌失败
            }
        })
    };
    //9.批量删除品牌
    $scope.del=()=>{
        brandService.del($scope.selectIds).success(resp=>{
            if(resp.success){
                $scope.search();  //批量删除品牌成功
            }else{
                alert(resp.message); //批量删除品牌失败
            }
        })
    }
});