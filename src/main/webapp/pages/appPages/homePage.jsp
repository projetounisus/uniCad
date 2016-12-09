<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="UTF-8"%>
<div ng-controller="mainPageCtrl">
	<div class="main-container">
		<div class="container">
			<div class="mdl-layout__tab-panel is-active">

				<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--4dp section-main-page">
					<div class="mdl-card mdl-cell mdl-cell--12-col mdl-card__supporting-text">
						<h4 class="card-title">Consultas e atendimentos</h4>
						
						<div class="container mdl-card-container">
							<div class="row">
								
								<div class="col-md-6 box-col">
									<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
										<h4>
											<a ng-click="listMedicRegisters()">Histórico de pacientes</a>
										</h4>

										<div>
											Lista todas as ocorreências médicas revelantes para o atendimento atual de forma a auxiliar à consulta ao paciente. <br/>
											O dados podem ser pesquisados o usuário por CNS, RG ou CPF.
											<br/>
										</div>

									</div>
								</div>

								<div class="col-md-6 box-col">
									<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
									
										<h4>
											<a href="#">Registros médicos</a>
										</h4>

										<div>
											Cria um novo registro médico, incrementando o conjunto de dados médicos e relacionando a ocorrências passadas para auxílio de atendimentos futuros
											<br/>
										</div>
												
									</div>
								</div>

								<!--<div class="col-md-4 box-col">
									<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
									
										<h4>
											<a href="#">Novo paciente</a>
										</h4>

										<div>
											Caso o paciente ainda não tenha sido cadastrado no sistema, aqui é possível adicionalo ao sistema
										<br/>
										
									</div>
								</div>								-->
							</div>
						</div>					
					</div>
				</section>	
				
				<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--4dp section-main-page">
					<div class="mdl-card mdl-cell mdl-cell--12-col mdl-card__supporting-text">
						<h4 class="card-title">Rede de sáude/Clínicas</h4>
						
						<div class="container mdl-card-container">
							<div class="row">
								<div class="col-md-6 box-col">
									<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
										<!-- O foco desta tela é manipulação de dados usuários possibilitando a pesquisa do mesmo via CPF, CNS ou número da identidade -->

										<h4>
											<a ng-click="listPacient()">Pacientes</a>
										</h4>

										<div>
											Lista todos os pacientes cadastrados em todas as unidades de saúde integradas pelo UniCad.
										</div>
									</div>
								</div>

								<div class="col-md-6 box-col ">
									<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
										<!-- O foco desta tela é manipulação de dados de médicos possibilitando a pesquisa do mesmo via CPF, CRM, estabalecimento ou número da identidade 
										-->

										<h4>
											<a ng-click="listMedics()">Médicos</a>
										</h4>

										<div>
											Lista todos os Médicos cadastrados em uma rede de sáude ou relacionados.
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-6 box-col">
									<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
										<!-- O foco desta tela é manipulação de dados de médicos possibilitando a pesquisa do mesmo via CPF, CRM, estabalecimento ou número da identidade 
										-->

										<h4>
											<a ng-click="listMedics()">Unidades de atendimento</a>
										</h4>

										<div>
											Lista todas as unidades de atendimento relacionadas a esta rede de clínicas.
										</div>
									</div>
								</div>

								<div class="col-md-6 box-col">
									<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
										<!-- O foco desta tela é manipulação de dados de médicos possibilitando a pesquisa do mesmo via CPF, CRM, estabalecimento ou número da identidade 
										-->

										<h4>
											<a ng-click="listMedics()">Rede de clínicas</a>
										</h4>

										<div>
											Atualize os dados administrativos da clínica
										</div>
									</div>
								</div>								
							</div>
						</div>
					</div>
				</section>

				<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--4dp section-main-page">
					<div class="mdl-card mdl-cell mdl-cell--12-col mdl-card__supporting-text">
						<h4 class="card-title">Gerenciamento do sistema</h4>
						
						<div class="container mdl-card-container">
							<div class="row">
								<div class="col-md-4 box-col">
									<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
										<!-- O foco desta tela é manipulação de dados usuários possibilitando a pesquisa do mesmo via CPF, CNS ou número da identidade -->

										<h4>
											<a href="/pacient-list">Especilidades médicas</a>
										</h4>

										<div>
											Lista todos as eespecilidades médicas cadastradas pelo UniCad.
										</div>
									</div>
								</div>

								<div class="col-md-4 box-col">
									<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
										<!-- O foco desta tela é manipulação de dados de médicos possibilitando a pesquisa do mesmo via CPF, CRM, estabalecimento ou número da identidade 
										-->

										<h4>
											<a ng-click="listMedics()">Tipos de registros médicos</a>
										</h4>

										<div>
											Tipos de registros médicos relacionados as suas correspondentes especialidades.
										</div>
									</div>
								</div>

								<div class="col-md-4 box-col">
									<div class="box mdl-card mdl-shadow--2dp mdl-card__supporting-text">
										<!-- O foco desta tela é manipulação de dados de médicos possibilitando a pesquisa do mesmo via CPF, CRM, estabalecimento ou número da identidade 
										-->

										<h4>
											<a ng-click="listMedics()">Redes de clínicas</a>
										</h4>

										<div>
											Tipos de registros médicos relacionados as suas correspondentes especialidades.
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
</div>