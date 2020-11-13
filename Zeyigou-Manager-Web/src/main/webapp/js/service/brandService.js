//brandService service层：专门负责与后端打交道发送路由给后端 然后接受后端返回的响应
app.service("brandService",function ($http) {

    //3.查询所有品牌
    this.findAll=()=>{
        //3.1)向后端发送请求
        return $http.get("../brand/list.do");
    };

    //4.分页查询品牌信息
    this.findByPage=(page,pageSize)=>{
        //4.1)将当前页与当前页显示的记录数传到后端
        return $http.get("../brand/findByPage.do?page="+page+"&pageSize="+pageSize);
    };

    //5.带条件的分页查询
    this.search=(page,pageSize,entity)=>{
        return $http.post("../brand/search.do?page="+page+"&pageSize="+pageSize,entity);
    };

    //7.保存品牌信息
    this.save=(url,entity)=>{
        return $http.post(url,entity);
    };
    //9.批量删除品牌
    this.del=(ids)=>{
        return $http.get("../brand/delete.do?ids="+ids);

    }
});