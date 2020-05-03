<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-12">            
    <div class="card card-primary">
        <div class="card-header">
            <h3 class="card-title">Cadastro de Despesa</h3>
        </div> 

        <form role="form" >
            <input type="hidden" name="ac" value="saveDespesa" />
            <div class="card-body">            
                <div class="form-group">
                    <label for="cpDescricao">Descrição:</label>
                    <input type="text" class="form-control" id="cpDescricao" name="cpDescricao" >
                </div>
                <div class="form-group">
                    <label for="cpValor">Valor:</label>
                    <input type="number" class="form-control" id="cpValor" name="cpValor" step="0.01">                    
                </div>
                <div class="form-group">
                        <label for="cpFoiPaga">Foi Paga?:</label>
                        <input type="checkbox" id="cpFoiPaga" name="cpFoiPaga" >
                    </div>

                <div class="form-group">
                    <label for="cpDataDespesa">Data da Despesa:</label>
                    <input type="date" class="form-control" id="cpDataDespesa" name="cpDataDespesa" value="${requestScope.dataAtual}">
                </div>                            

                <div class="form-group">
                    <label>Observação</label>
                    <textarea class="form-control" rows="3" placeholder="Observação" name="cpObservacao"></textarea>
                </div>                              

                <div class="form-group">
                    <label>Categoria</label>
                    <select id="cpCategoria" name="cpCategoria">
                        <c:forEach items="${requestScope.categorias}" var="c">
                            <option value="${c.id}">${c.nome}</option>
                        </c:forEach>
                    </select>
                </div>                     
                
                <div class="form-group">
                    <label>Usuário</label>
                    <select id="cpUsuario" name="cpUsuario">
                        <c:forEach items="${requestScope.usuarios}" var="u">
                            <option value="${u.id}">${u.nome}</option>
                        </c:forEach>
                    </select>
                </div>              
                
            </div>
            <div class="card-footer">
                <button type="submit" class="btn btn-primary">Salvar</button>
            </div>
        </form>
    </div>   
</div>