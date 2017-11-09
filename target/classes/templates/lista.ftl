<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead"> Usuário </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.usuario.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Nome</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.usuario.nome" id="uname" class="username form-control input-sm" placeholder="Digite seu nome" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
 
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="cpf">CPF</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.usuario.cpf" id="cpf" class="form-control input-sm" placeholder="Digite seu cpf." required ng-pattern="ctrl.onlyIntegers"/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="telefone">Telefone</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.usuario.contato.telefone" id="telefone" class="form-control input-sm" placeholder="Digite seu telefone." required ng-pattern="ctrl.onlyIntegers"/>
                            </div>
                        </div>
                    </div>
                    
                             <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="celular">Celular</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.usuario.contato.celular" id="celular" class="form-control input-sm" placeholder="Digite seu celular." required ng-pattern="ctrl.onlyIntegers"/>
                            </div>
                        </div>
                    </div>
                    
                             <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="email">Email</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.usuario.contato.email" id="email" class="form-control input-sm" placeholder="Digite seu email." required />
                            </div>
                        </div>
                    </div>
                    
                    
                        
 
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.usuario.id ? 'Salvar' : 'Atualizar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Lista de usuários </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOME</th>
                        <th>CPF</th>
                        <th>Telefone</th>
                        <th>Celular</th>   
                        <th>Email</th>                                  
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.listarUsuario()">
                        <td>{{u.id}}</td>
                        <td>{{u.nome}}</td>
                        <td>{{u.cpf}}</td>
                        <td>{{u.contato.telefone}}</td>
                        <td>{{u.contato.celular}}</td>
                        <td>{{u.contato.email}}</td>                                         
                        <td><button type="button" ng-click="ctrl.editarUsuario(u.id)" class="btn btn-success custom-width">Editar</button></td>
                        <td><button type="button" ng-click="ctrl.excluirUsuario(u.id)" class="btn btn-danger custom-width">Excluir</button></td>
                    </tr>
                    </tbody>
                </table>      
            </div>
        </div>
    </div>
</div>