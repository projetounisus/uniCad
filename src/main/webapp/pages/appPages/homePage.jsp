<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="ISO-8859-15"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<div ng-controller="mainPageCtrl" class="main-container">
	<div class="container">
		<div class="mdl-layout__tab-panel is-active">
			
			<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--4dp section-main-page">
				<div class="mdl-card mdl-cell mdl-cell--12-col mdl-card__supporting-text">
					<h4 class="card-title">Gerenciamento e manutenção de dados</h4>
					
					<div class="container mdl-card-container">
						<div class="row">
							<div class="col-md-4">
								<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
									<h4>
										<a ng-click="listUsers()">Usuários</a>
									</h4>

									<div>
										Lista todos os usuários cadastrados no sistema, mostrando profissionais do sistema local e pacientes de todo o sistema integrado
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
									<!-- O foco desta tela é manipulação de dados usuários possibilitando a pesquisa do mesmo via CPF, CNS ou número da identidade -->

									<h4>
										<a href="/pacient-list">Pacientes</a>
									</h4>

									<div>
										Lista todos os pacientes cadastrados em todas as unidades de saúde integradas pelo UniCad
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
									<!-- O foco desta tela é manipulação de dados de médicos possibilitando a pesquisa do mesmo via CPF, CRM, estabalecimento ou número da identidade 
									-->

									<h4>
										<a ng-click="listMedics()">Médicos</a>
									</h4>

									<div>
										Lista todos os Médicos cadastrados em uma rede de sáude ou relacionados
									</div>
								</div>
							</div>								
						</div>
					</div>
				</div>
			</section>

			<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--4dp section-main-page">
				<div class="mdl-card mdl-cell mdl-cell--12-col mdl-card__supporting-text">
					<h4 class="card-title">Consultas e atendimentos</h4>
					
					<div class="container mdl-card-container">
						<div class="row">
							
							<div class="col-md-6">
								<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
									<!-- O foco desta tela é manipulação de dados de médicos possibilitando a pesquisa do mesmo via CPF, CRM, estabalecimento ou número da identidade 
									-->

									<h4>
										Histórico de pacientes
									</h4>

									<div>
										Lista todas as ocorreências médicas revelantes para o atendimento atual de forma a auxiliar à consulta ao paciente. <\br>
										O dados podem ser pesquisando o usuário por CNS, RG ou CPF.
									</div>

									<!-- Ajustar os etilos destes inputs e extenálos no style.css  -->
									<div class="container mdl-card-container">
										<div class="row">
											<div class="col-md-4">
												<select style="margin:5px">
													<option>Mock</option>
												</select> 
											</div>
											
											<div class="col-md-4">
												
												<input type="text" name="" style="margin:5px"/> 
											</div>
											
											<div class="col-md-4">
												<button class="btn btn-primary" style="margin:5px">Consultar</button>
											</div>
										</div>
									</div>
								</div>
							</div>								
						</div>
					</div>
				</div>
			</section>	
		</div>
	</div>
</div>