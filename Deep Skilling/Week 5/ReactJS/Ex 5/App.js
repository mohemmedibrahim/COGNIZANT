import CohortDetails from "./CohortDetails";

function App() {

  return (

    <div>

      <CohortDetails
        title="React"
        startedOn="10-Jul-2026"
        status="ongoing"
        coach="John"
        trainer="David"
      />

      <CohortDetails
        title="Java"
        startedOn="15-Jun-2026"
        status="completed"
        coach="Peter"
        trainer="James"
      />

    </div>

  );

}

export default App;