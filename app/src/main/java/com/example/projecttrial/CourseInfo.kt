package com.example.projecttrial

object Info {
    private val courseMap = mapOf(
        "Astrobiology" to CourseDetails(
            paragraph1 = "Astrobiology explores how life originated on Earth and how it might have emerged on other planets or moons. It considers the potential future of life on Earth and in the universe, including the impact of space exploration and potential extraterrestrial environments. ",
            paragraph2 = "It is an interdisciplinary study combining knowledge from fields like biology, astronomy, geology and chemistry to investigate life's potential presence and development beyond Earth. ",
            paragraph3 = "Top schools include University of Arizona and Edinburgh. NASA also hires graduates.",
            url = "https://astrobiology.nasa.gov/about/"
        ),
        "Digital Anthropology" to CourseDetails(
            paragraph1 = "Digital anthropology is a subfield of anthropology that studies the relationship between humans and digital technologies. It explores how technology shapes human behaviour, culture and perceptions of the world, as well as how humans, in turn, shape the development and use of technology. ",
            paragraph2 = "This involves examining how social media, virtual worlds, artificial intelligence and other digital tools influence social interactions, communication patterns and cultural norms. By understanding user behaviour and cultural contexts, digital anthropologists can contribute to the design of more accessible, user-friendly and culturally appropriate technologies.",
            paragraph3 = "UCL, MIT and Stanford offer great programs. Careers in UX and cultural tech await.",
            url = "https://maggieappleton.com/digital-anthropology/"
        ),
        "Ethnomusicology" to CourseDetails(
            paragraph1 = "Ethnomusicologists study music as a reflection of culture and investigate the act of music-making through various immersive, observational and analytical approaches. The practice of ethnomusicology relies on direct engagement and performance, as well as academic work. ",
            paragraph2 = "Fieldwork takes place among those who make the music, engaging local languages and culture as well as music. Ethnomusicologists can become participant observers, learning to perform the music they are studying. Fieldworkers also collect recordings and contextual data. ",
            paragraph3 = "Ethnomusicology combines perspectives from folklore, psychology, linguistics, music theory, and history. Offered by UCLA and University of Washington",
            url = "https://www.ethnomusicology.org/page/AboutEthnomusicol"
        ),
        "Science Journalism" to CourseDetails(
            paragraph1 = "Science journalists act as intermediaries, bridging the gap between the scientific community and the public by explaining complex scientific concepts in an understandable way. They strive to make scientific information accessible to a wide audience, regardless of their background or prior knowledge. ",
            paragraph2 = "Science journalists also engage in investigative reporting, scrutinizing scientific claims, exposing misinformation and holding institutions accountable. The field is constantly evolving with the rise of online media and the increasing need for fact-checking and debunking misinformation. ",
            paragraph3 = "Concordia University and University of Missouri offer these programs.",
            url = "https://www.theopennotebook.com/getting-started-in-science-journalism/"
        ),
        "Game Narrative Design" to CourseDetails(
            paragraph1 = "Narrative designers craft the emotional journey and the player's experience of the story within a game. They are responsible for making sure the narrative isn't just a backdrop but an integral part of the gameplay that resonates with players on a deeper level. They develop the structure including plot, characters and the game's world, ensuring it's compelling and cohesive. ",
            paragraph2 = "They consider how players will react to the story, anticipating their actions and designing narrative elements that are both meaningful and enjoyable.",
            paragraph3 = "Offered by Georgia Institute of Technology and University of Utah",
            url = "https://www.cgspectrum.com/career-pathways/narrative-designer"
        ),
        "Physics" to CourseDetails(
            paragraph1 = "A Bachelor of Science in Physics, provides a strong foundation in the principles of physics and related fields. It involves both theoretical and practical coursework, covering areas like classical mechanics, electromagnetism, quantum mechanics and thermodynamics. ",
            paragraph2 = "Graduates can pursue careers in various sectors, including research, education and industries like IT, finance, and engineering. ",
            paragraph3 = "Offered by University of Nairobi, Moi University, MIT, Harvard University",
            url = "https://www.iop.org/careers-physics/your-future-with-physics/career-paths"
        ),
        "Chemistry" to CourseDetails(
            paragraph1 = "A Bachelor of Chemistry degree provides a foundational understanding of the properties and reactions of matter. It typically covers core areas like organic, inorganic and physical chemistry, as well as analytical and sometimes biochemistry.",
            paragraph2 = "Skills gained can be used in diverse fields, like healthcare and environmental science. Specialization can be in areas like analytical chemistry (measuring and identifying chemical substances), biochemistry (chemical processes within living organisms) or environmental chemistry (chemical processes in the environment). ",
            paragraph3 = "Offered by Multimedia University of Kenya, University of Nairobi and many other top Universities.",
            url = "https://nationalcareers.service.gov.uk/job-profiles/chemist"
        ),
        "Biology" to CourseDetails(
            paragraph1 = "A Bachelor of Biology degree provides a comprehensive understanding of life and its processes, encompassing various sub-disciplines like zoology, botany and molecular biology. Biology is inherently interdisciplinary, often involving collaborations with other fields like chemistry, physics, and mathematics. ",
            paragraph2 = "Many programs emphasize practical skills through laboratory work, field studies, and research opportunities. Biology is a dynamic field, constantly evolving with new discoveries and technologies, requiring continuous learning and adaptation. ",
            paragraph3 = "Offered by University of Waterloo, Emory University, Kenyatta University. ",
            url = " https://www.bethel.edu/blog/versatility-of-a-biology-degree/"
        ),
        "Programming" to CourseDetails(
            paragraph1 = "A Bachelor of Programming degree equips students with the skills and knowledge to develop software, manage data and solve complex problems using computer code. These programs typically cover programming languages, data structures, algorithms and understanding how software interacts with hardware and other systems.  ",
            paragraph2 = "A strong emphasis is placed on developing the ability to analyse problems and translate them into efficient and effective code. Some programs offer specializations in areas like web development, game programming, or cybersecurity. ",
            paragraph3 = "Offered by Strathmore University, Stanford University, Harvard University.",
            url = "https://research.com/careers/computer-programming-careers#:~:text=Web%20Developers%20and%20Digital%20Designers,and%20systems%20for%20optimal%20performance."
        ),
        "Networks" to CourseDetails(
            paragraph1 = "A Bachelor of Networks degree focuses on the design, implementation and management of computer networks. These programs equip students with the knowledge and skills to work in various roles related to network administration, system administration and ICT services. ",
            paragraph2 = "Expertise is gained in securing networks against threats, including vulnerability testing, intrusion detection and security policies. It also includes managing and maintaining computer systems, servers, and network infrastructure. ",
            paragraph3 = "Offered by University of Cape Town, University of Ghana, Moi University.",
            url = "https://www.sans.org/blog/network-engineer-salary-skills-and-career-path/"
        ),
        "Cybersecurity" to CourseDetails(
            paragraph1 = "A Bachelor of Cybersecurity degree prepares individuals for careers focused on protecting computer systems and networks from cyber threats. It equips graduates with the knowledge and skills to design, implement and manage security measures, assess vulnerabilities and respond to security incidents.",
            paragraph2 = "The curriculum typically covers topics like network security, cryptography, ethical hacking, digital forensics and security management. Cybersecurity is a rapidly growing field with high demand for skilled professionals.",
            paragraph3 = "Offered in Strathmore University, Air Force Institute of Technology, MIT.",
            url = "https://www.simplilearn.com/tutorials/cyber-security-tutorial/cyber-security-career-path"
        ),
        "History" to CourseDetails(
            paragraph1 = "A Bachelor of History degree provides students with a comprehensive understanding of the past. It explores various historical periods, regions and themes. Students gain in-depth knowledge of world history, including specific regions like Africa, Europe and Asia, as well as thematic areas like economic, political, and social history.",
            paragraph2 = "The program emphasizes developing research skills, including source analysis, interpretation and synthesis of historical information. Many history programs encourage an interdisciplinary approach, allowing students to explore connections between history and other fields like political science, sociology and economics.",
            paragraph3 = "Offered by University of Pretoria, Columbia University, YALE University.",
            url = "https://www.indeed.com/career-advice/finding-a-job/bachelor-in-history"
        ),
        "Philosophy" to CourseDetails(
            paragraph1 = "A  Philosophy degree provides a broad understanding of philosophical concepts, theories and arguments. Focuses on areas like metaphysics, epistemology, ethics and logic. This develops critical thinking, analytical reasoning, clear communication and problem-solving abilities. ",
            paragraph2 = "It also opens doors to diverse fields such as law, journalism, education, public policy, social work and consulting. It can also serve as a foundation for advanced studies in law, theology or related disciplines. ",
            paragraph3 = "Offered by University of Nairobi, Australian National University, University of Oxford.",
            url = "https://www.crimsoneducation.org/us/blog/exploring-avenues-with-a-philosophy-degree/"
        ),
        "Languages" to CourseDetails(
            paragraph1 = "A Bachelor of Languages degree provides a pathway to proficiency in one or more foreign languages, encompassing linguistic, cultural and communication skills. It typically involves in-depth study of the chosen language(s), their respective cultures and also integrates broader skills like intercultural communication and translation. ",
            paragraph2 = "The degree incorporates the study of the culture, history and society associated with the chosen language(s). Students gain the ability to navigate and understand different cultural contexts, a valuable asset in a globalized world.  Students can often tailor their studies by choosing specific language combinations and focusing on areas of interest within the language and culture. ",
            paragraph3 = "Offered by University of New England, University of Nairobi, University of Sydney. ",
            url = "https://www.indeed.com/career-advice/finding-a-job/jobs-for-language-majors"
        ),

        )

fun getDetails(course: String): CourseDetails{
    return courseMap[course] ?: CourseDetails(
        paragraph1 = "This course offers unique insights and applications.",
        paragraph2 = "Programs usually last 3–4 years and build cross-discipline skills.",
        paragraph3 = "Check universities and programs offering this specialization.",
        url = "https://www.google.com/search?q=$course degree"
    )
}

}