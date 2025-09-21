// Simple mock data storage (for demo purposes only)
let patients = [];
let doctors = [];
let appointments = [];

let patientId = 1;
let doctorId = 1;
let appointmentId = 1;

// ===== PATIENTS =====
const patientForm = document.getElementById("patientForm");
if (patientForm) {
  patientForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const name = document.getElementById("pName").value;
    const age = document.getElementById("pAge").value;
    const gender = document.getElementById("pGender").value;

    patients.push({ id: patientId++, name, age, gender });
    displayPatients();
    patientForm.reset();
  });
}

function displayPatients() {
  const tableBody = document.querySelector("#patientTable tbody");
  if (!tableBody) return;
  tableBody.innerHTML = "";
  patients.forEach((p) => {
    const row = `<tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.age}</td>
      <td>${p.gender}</td>
    </tr>`;
    tableBody.innerHTML += row;
  });
}

// ===== DOCTORS =====
const doctorForm = document.getElementById("doctorForm");
if (doctorForm) {
  doctorForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const name = document.getElementById("dName").value;
    const specialization = document.getElementById("dSpecialization").value;

    doctors.push({ id: doctorId++, name, specialization });
    displayDoctors();
    doctorForm.reset();
  });
}

function displayDoctors() {
  const tableBody = document.querySelector("#doctorTable tbody");
  if (!tableBody) return;
  tableBody.innerHTML = "";
  doctors.forEach((d) => {
    const row = `<tr>
      <td>${d.id}</td>
      <td>${d.name}</td>
      <td>${d.specialization}</td>
    </tr>`;
    tableBody.innerHTML += row;
  });
}

// ===== APPOINTMENTS =====
const appointmentForm = document.getElementById("appointmentForm");
if (appointmentForm) {
  appointmentForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const patientId = document.getElementById("aPatientId").value;
    const doctorId = document.getElementById("aDoctorId").value;
    const date = document.getElementById("aDate").value;

    appointments.push({ id: appointmentId++, patientId, doctorId, date });
    displayAppointments();
    appointmentForm.reset();
  });
}

function displayAppointments() {
  const tableBody = document.querySelector("#appointmentTable tbody");
  if (!tableBody) return;
  tableBody.innerHTML = "";
  appointments.forEach((a) => {
    const row = `<tr>
      <td>${a.id}</td>
      <td>${a.patientId}</td>
      <td>${a.doctorId}</td>
      <td>${a.date}</td>
    </tr>`;
    tableBody.innerHTML += row;
  });
}
// Fetch all patients
fetch('http://localhost:8080/patients')
  .then(res => res.json())
  .then(patients => {
      const list = document.getElementById('patient-list');
      list.innerHTML = '';
      patients.forEach(p => {
          const li = document.createElement('li');
          li.textContent = `${p.name} (${p.age} years old)`;
          list.appendChild(li);
      });
  });

// Fetch doctors
fetch('http://localhost:8080/doctors')
  .then(res => res.json())
  .then(doctors => {
      const list = document.getElementById('doctor-list');
      list.innerHTML = '';
      doctors.forEach(d => {
          const li = document.createElement('li');
          li.textContent = `${d.name} - ${d.specialty}`;
          list.appendChild(li);
      });
  });
