-- Buscar os nomes de todos os alunos que frequentam alguma turma do professor 'JOAO PEDRO'.
SELECT Nome
  FROM ALUNO
  WHERE id IN (SELECT aluno_id
                FROM ALUNO_TURMA JOIN TURMA JOIN PROFESSOR ON (ALUNO_TURMA.turma_id=TURMA.id AND TURMA.PROFESSOR_id=PROFESSOR.id)
                WHERE PROFESSOR.nome = 'JOAO PEDRO')

-- Buscar os dias da semana que tenham aulas da disciplina 'MATEMATICA'.
SELECT DISTINCT dia_da_semana
  FROM TURMA JOIN DISCIPLINA ON TURMA.DISCIPLINA_id=DISCIPLINA.id
  WHERE DISCIPLINA.nome = 'MATEMATICA'

-- Buscar todos os alunos que frequentem aulas de 'MATEMATICA' e também 'FISICA'.
SELECT Nome
  FROM ALUNO
  WHERE id IN (SELECT aluno_id
                FROM ALUNO_TURMA JOIN TURMA JOIN DISCIPLINA ON (ALUNO_TURMA.turma_id=TURMA.id AND TURMA.DISCIPLINA_id=DISCIPLINA.id)
                 WHERE nome = 'MATEMATICA')
        AND IN (SELECT aluno_id
                      FROM ALUNO_TURMA JOIN TURMA JOIN DISCIPLINA ON (ALUNO_TURMA.turma_id=TURMA.id AND TURMA.DISCIPLINA_id=DISCIPLINA.id)
                       WHERE nome = 'FISICA')

-- Buscar as disciplinas que não tenham nenhuma turma.
SELECT nome
  FROM DISCIPLINA
  WHERE id NOT IN (SELECT DISCIPLINA_id FROM TURMA)

-- Buscar os alunos que frequentem aulas de 'MATEMATICA' exceto os que frequentem 'QUIMICA'.
SELECT Nome
  FROM ALUNO
  WHERE id IN (SELECT aluno_id
                FROM ALUNO_TURMA JOIN TURMA JOIN DISCIPLINA ON (ALUNO_TURMA.turma_id=TURMA.id AND TURMA.DISCIPLINA_id=DISCIPLINA.id)
                WHERE DISCIPLINA.nome = 'MATEMATICA')
        AND NOT IN (SELECT aluno_id
                    FROM ALUNO_TURMA JOIN TURMA JOIN DISCIPLINA ON (ALUNO_TURMA.turma_id=TURMA.id AND TURMA.DISCIPLINA_id=DISCIPLINA.id)
                    WHERE DISCIPLINA.nome = 'QUIMICA')
