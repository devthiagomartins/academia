package br.com.thiago.academia;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.datetime.joda.LocalDateTimeParser;

import br.com.thiago.academia.domain.Aparelho;
import br.com.thiago.academia.domain.Categoria;
import br.com.thiago.academia.domain.Cidade;
import br.com.thiago.academia.domain.Cliente;
import br.com.thiago.academia.domain.Endereco;
import br.com.thiago.academia.domain.Estado;
import br.com.thiago.academia.domain.Exercicio;
import br.com.thiago.academia.domain.FichaDeAvaliacaoFisica;
import br.com.thiago.academia.domain.FichaDeTreino;
import br.com.thiago.academia.domain.Instrutor;
import br.com.thiago.academia.domain.enums.EstadoCivil;
import br.com.thiago.academia.domain.enums.Genero;
import br.com.thiago.academia.domain.enums.Intensidade;
import br.com.thiago.academia.domain.enums.Status;
import br.com.thiago.academia.domain.enums.StatusAparelho;
import br.com.thiago.academia.domain.enums.StatusTreino;
import br.com.thiago.academia.repositories.AparelhoRepository;
import br.com.thiago.academia.repositories.CategoriaRepository;
import br.com.thiago.academia.repositories.CidadeRepository;
import br.com.thiago.academia.repositories.ClienteRepository;
import br.com.thiago.academia.repositories.EnderecoRepository;
import br.com.thiago.academia.repositories.EstadoRepository;
import br.com.thiago.academia.repositories.ExercicioRepository;
import br.com.thiago.academia.repositories.FichaDeAvaliacaoFisicaRepository;
import br.com.thiago.academia.repositories.FichaDeTreinoRepository;
import br.com.thiago.academia.repositories.InstrutorRepository;

@SpringBootApplication
public class AcademiaApplication implements CommandLineRunner{

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private InstrutorRepository instrutorRepository;
	@Autowired
	private FichaDeAvaliacaoFisicaRepository fichaDeAvaliacaoFisicaRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private AparelhoRepository aparelhoRepository;
	@Autowired
	private FichaDeTreinoRepository fichaDeTreinoRepository;
	@Autowired
	private ExercicioRepository exercicioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AcademiaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Estado estado01 = new Estado(null, "Goiás");
		
		Cidade cidade01 = new Cidade(null, "Goiânia", estado01);
		Cidade cidade02 = new Cidade(null, "Aragoiânia", estado01);
		
		
		Cliente cliente01 = new Cliente(null, "Arnaldo", "357.753.700-07", "arnaldo@email.com", LocalDateTime.now(), Status.ATIVO, Genero.MASCULINO, 
										LocalDate.of(2000, 1, 28), "50.207.464-4", EstadoCivil.SOLTEIRO, "primeiro contato com academia");
		
		cliente01.getTelefones().addAll(Arrays.asList("99852208","99561044"));
		
		Endereco endereco01 = new Endereco(null, "Rua CP19", "156-CP","Quadra CP 7", "Celina Park", "74.373-190", cidade01, cliente01);
		Endereco endereco02 = new Endereco(null, "Rua ED 45", "1", "Quadra ED 20", "Eldorado", "74.179-505", cidade01, cliente01);
		
		Instrutor instrutor01 = new Instrutor(null, "Laura", "123987-G/GO", LocalDateTime.now(), Status.ATIVO, Genero.FEMININO, "instrutora freelancer");
		
		FichaDeAvaliacaoFisica avaliacao01 = new FichaDeAvaliacaoFisica(null, 74.0, LocalDateTime.now(),2.300, 19, 52.6, 1.5, 2.3, 29.2, 43.2, 18.7, "fazer exame de sangue", cliente01, instrutor01);
		FichaDeAvaliacaoFisica avaliacao02 = new FichaDeAvaliacaoFisica(null, 71.0, LocalDateTime.of(LocalDate.of(2021, 12, 27), LocalTime.of(14, 00)),
																		2.600, 19, 50.0, 1.0, 2.3,25.0, 46.0, 17.9, "reavaliar taxa de lipideos semanal", cliente01, instrutor01);
		
		Categoria categoria01 = new Categoria(null,"Membros superiores");
		Categoria categoria02 = new Categoria(null,"Membros inferiores");
		
		Aparelho aparelho01 = new Aparelho(null, "Smith", 300.00, StatusAparelho.NORMAL, "aparelho para treino");
		Aparelho aparelho02 = new Aparelho(null,"cavalinho", 150.00, StatusAparelho.MANUTENCAO, "aparelho quebrado por excesso de peso");
		
		FichaDeTreino fichaDeTreino01 = new FichaDeTreino(null, "Ficha de Treino 01", StatusTreino.ANDAMENTO, LocalDateTime.now(), LocalDate.of(2021, 12, 8), LocalDate.of(2021, 12, 26),"Ganho de massa muscular", 6, "ficha referente mes 12/2021", instrutor01, cliente01);
		FichaDeTreino fichaDeTreino02 = new FichaDeTreino(null, "Ficha de Treino 02", StatusTreino.CANCELADO, LocalDateTime.now(), LocalDate.of(2021, 12, 28), LocalDate.of(2022, 01, 18),"Secar e queimar gorduras", 4, "repetir ficha no mes 02/2022", instrutor01, cliente01);
		
		
		Exercicio exercicio01 = new Exercicio(null, "Agachamento", 3, 15, 30.0, 30.0, Intensidade.MODERADA, null, fichaDeTreino02, categoria02, aparelho01);
		Exercicio exercicio02 = new Exercicio(null, "Triceps corda",2, 15, 40.0, 40.0, Intensidade.LEVE, "drop-set", fichaDeTreino02, categoria01, aparelho02);
		Exercicio exercicio03 = new Exercicio(null, "Afundo",3, 15, 25.0, 30.0, Intensidade.LEVE, null, fichaDeTreino02, categoria02, aparelho01);

		
		estadoRepository.saveAll(Arrays.asList(estado01));
		cidadeRepository.saveAll(Arrays.asList(cidade01, cidade02));
		clienteRepository.saveAll(Arrays.asList(cliente01));
		enderecoRepository.saveAll(Arrays.asList(endereco01,endereco02));
		instrutorRepository.saveAll(Arrays.asList(instrutor01));
		fichaDeAvaliacaoFisicaRepository.saveAll(Arrays.asList(avaliacao01,avaliacao02));
		categoriaRepository.saveAll(Arrays.asList(categoria01,categoria02));
		aparelhoRepository.saveAll(Arrays.asList(aparelho01,aparelho02));
		fichaDeTreinoRepository.saveAll(Arrays.asList(fichaDeTreino01,fichaDeTreino02));
		exercicioRepository.saveAll(Arrays.asList(exercicio01,exercicio02,exercicio03));
		
	}

}
