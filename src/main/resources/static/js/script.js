document.addEventListener('DOMContentLoaded', () => {
    const greetingText = document.querySelector('.hero-subtitle');
    const hour = new Date().getHours();

    if (greetingText) {
        const part = hour < 12 ? 'Boa dia' : hour < 18 ? 'Boa tarde' : 'Boa noite';
        greetingText.textContent = `${part}! Transformamos doações em impacto real com controle, transparência e carinho.`;
    }

    const yearSpan = document.getElementById('currentYear');
    if (yearSpan) {
        yearSpan.textContent = new Date().getFullYear();
    }
});

function atualizarRelogio() {
    const agora = new Date();
    const horas = String(agora.getHours()).padStart(2, '0');
    const minutos = String(agora.getMinutes()).padStart(2, '0');
    const segundos = String(agora.getSeconds()).padStart(2, '0');
    document.getElementById('relogio').textContent = `${horas}:${minutos}:${segundos}`;
}

atualizarRelogio(); // roda imediatamente
setInterval(atualizarRelogio, 1000); // atualiza a cada segundo
