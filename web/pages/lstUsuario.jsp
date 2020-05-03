<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Usuários</h3>
                <div class="container" id="listagem">
                    <div id="dvExclusao" name="dvExclusao" >&nbsp;</div>    
                </div>
                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>                                           
                      <th>Nome</th>
                      <th>E-mail</th>
                      <th>Administrador</th>      
                      <c:if test="${requestScope.usr.ehAdministrador == false}" >
                        <th>Ações</th>          
                      </c:if>
                    </tr>
                  </thead>
                  <tbody>                  
                    <c:forEach items="${requestScope.lista}" var="usr" >
                        <tr>
                            <td>${usr.nome}</td>                                         
                            <td>${usr.email}</td>                                                                 
                            <c:if test="${usr.ehAdministrador == false}" >
                                <td><i class="fa fa-ban" aria-hidden="true" title="Não" ></td>      
                            </c:if>
                            <c:if test="${usr.ehAdministrador != false}" >
                                <td><i class="fa fa-check" title="Sim" ></td>      
                            </c:if>
                                 <td>
                                    <a href="app?ac=editUsuario&id=${usr.id}"> 
                                        <i class="fa fa-edit" title="alterar usuario" ></i></a>
                                    <a href="#" id="opDel${usr.id}" data-id="${usr.id}">
                                        <i class="fa fa-minus-circle" title="apagar usuario" ></i></a>                        
                                </td>
                        </tr>
                    </c:forEach>                             
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
<script>        
    $('a[id*="opDel"]').on("click", function () {
            $.ajax({
                type: "POST",    
                url: "app?ac=delUsuario",
                data: {'id' : $(this).data('id') },    
                cache: false,
                timeout: 600000,
                success: function (data) {
                    console.log("SUCCESS : ", data);
                    $("#dvExclusao").html(data);
                },
                error: function (e) {

                    var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                            + e.responseText + "&lt;/pre&gt;";                    

                    console.log("ERROR : ", json);
                    console.log("ERROR : ", e);
                    alert("Não conseguimos buscar a exclusão")

                }
            });
        });    
</script>