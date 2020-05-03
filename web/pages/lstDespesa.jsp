<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Despesas</h3>
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
                      <th>Data</th>
                      <th>Descrição</th>
                      <th>Valor(R$)</th>
                      <th>Paga?</th>                     
                      <th>Ações</th>                     
                    </tr>
                  </thead>
                  <tbody>                  
                    <c:forEach items="${requestScope.lista}" var="desp" >
                        <tr>
                            <td>${desp.dataFormatada}</td>                                         
                            <td>${desp.descricao}</td>                            
                            <td>${desp.valor}</td>                                   
                            <c:if test="${desp.foiPaga == false}" >
                                <td><i class="fa fa-ban" aria-hidden="true" title="Não" ></td>      
                            </c:if>
                            <c:if test="${desp.foiPaga != false}" >
                                <td><i class="fa fa-check" title="Sim" ></td>      
                            </c:if>
                                 <td>
                                    <a href="app?ac=editDespesa&id=${desp.id}"> 
                                        <i class="fa fa-edit" title="alterar despesa" ></i></a>
                                    <a href="#" id="opDel${desp.id}" data-id="${desp.id}">
                                        <i class="fa fa-minus-circle" title="apagar despesa" ></i></a>                        
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
        <!-- /.row -->
<script> 
       
    $('a[id*="opDel"]').on("click", function () {
            $.ajax({
                type: "POST",    
                url: "app?ac=delDespesa",
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